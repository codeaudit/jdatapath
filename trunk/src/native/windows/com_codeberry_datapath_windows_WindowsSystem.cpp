#include <shlobj.h>
#include "com_codeberry_datapath_windows_WindowsSystem.h"

JNIEXPORT jstring JNICALL Java_com_codeberry_datapath_windows_WindowsSystem_SHGetPathFromIDList(JNIEnv *env, jclass jcls, jint csidl) {
  // Credit: Copied from "http://justcheckingonall.wordpress.com/2008/05/16/find-shell-folders-win32/" :)

	// Allocate a pointer to an Item ID list
	LPITEMIDLIST pidl;

	// Get a pointer to an item ID list that represents the path of a special folder
	HRESULT hr = SHGetSpecialFolderLocation(NULL, (int)csidl, &pidl);

	// Convert the item ID list's binary representation into a file system path
	char szPath[_MAX_PATH + 1] = "";
	//char szPath[1024*256];
	//memset(szPath,'\0',1024*256);
	BOOL success = SHGetPathFromIDList(pidl, szPath);

	// Allocate a pointer to an IMalloc interface
	LPMALLOC pMalloc;

	// Get the address of our task allocator's IMalloc interface
	hr = SHGetMalloc(&pMalloc);

	// Free the item ID list allocated by SHGetSpecialFolderLocation
	pMalloc->Free(pidl);

	// Free our task allocator
	pMalloc->Release();

	// Work with the special folder's path (contained in szPath)...
	if(success) {
		return env->NewStringUTF(szPath);
	}
	return NULL;
}