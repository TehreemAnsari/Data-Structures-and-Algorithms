#include"Vfs.h"
struct Vfs svfs;
int vfs_load(char* name_with_path)
{
	//open file;
	FILE *fp2;
if(!(fp2=fopen(name_with_path,"r+")))
	{
printf("file dint opened\n");
	}
	else
	{
		printf("opened\n");
		fseek(fp2,0,SEEK_SET);
	struct Vfs_HeaderInfo t2;
	
	//load header into struct

	if(!feof(fp2)){
	fread(&svfs,sizeof(struct Vfs),1,fp2);
	struct Vfs_Info vinfo;
	t2=svfs.Header;

	svfs.Vfs_status=0;
	svfs.Vfs_ptr=fp2;
	struct Vfs_FileInfo vfsfil[MAX_FILE];
	vinfo=t2.vfs_info;
	
	int i=0;
	printf("VFS Name= %s\n",vinfo.Vfs_name);
	printf("VFS num_files= %d\n",vinfo.num_files);
	i=0;
	
	while(i<vinfo.num_files)
	{
	vfsfil[i]=t2.vfsfiles[i];
	printf("file name= %s , size = %d\n",vfsfil[i].fname,vfsfil[i].size);
	i++;
	}

	}
	
	}

	return 0;

}
