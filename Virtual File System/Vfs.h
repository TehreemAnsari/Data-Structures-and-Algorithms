#include<stdio.h>
#include<string.h>

#define MAXLEN 30		//max file name length
#define MAX_FILE 5		//max no of files
#define VFS_OPEN 0		//is file open or closed
#define VFS_CLOSE 1	

int vfs_create(char * name_with_path);	//create a new file using fopen, initialize&save HeaderInfo.
int vfs_load(char* name_with_path);		//same as vfs_open. load header info into struct
int vfs_save(char * name, char * name_with_path);	//write external file contents location in offset location.
int vfs_unload();	

struct Vfs_FileInfo{
	char fname[MAXLEN];
	int size;
};

struct Vfs_Info{
char Vfs_name[MAXLEN];
int num_files;
};

struct Vfs_HeaderInfo{
	struct Vfs_Info vfs_info;
	struct Vfs_FileInfo vfsfiles[MAX_FILE];
};

struct Vfs{
	struct Vfs_HeaderInfo Header;
	FILE *Vfs_ptr;	//pointer to the file
	int Vfs_status;	//if file in use then status=0, else 1.
};
