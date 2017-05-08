#include"Vfs.h"

extern struct Vfs svfs;
int vfs_unload()
{
	svfs.Vfs_status=1;
	svfs.Vfs_ptr=NULL;
	printf("File System Unloaded");
return 0;
}
