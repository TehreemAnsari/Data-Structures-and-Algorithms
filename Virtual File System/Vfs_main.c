#include"Vfs.h"
int main()
{
	int temp=vfs_create("myfilesystem");
	if(temp==0)
	{
		printf("file creation\n");
	}
	int  save=vfs_save("test1.txt","myfilesystem");
	if(save==0)
	{
		printf("file 1 save done\n");
	}
	save=vfs_save("test2.txt","myfilesystem");
	if(save==0)
	{
		printf("file 2 save done\n");
	}
	int unload=vfs_unload("test1.txt","myfilesystem");
	if(unload==0)
	{
		printf("unloading done");
	}
	unload=vfs_unload("test2.txt","myfilesystem");
	if(unload==0)
	{
		printf("unloading done");
	}
	
	return 0;
}
