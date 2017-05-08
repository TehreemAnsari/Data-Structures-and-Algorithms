#include"Vfs.h"

int vfs_create(char * name_with_path)
{
	FILE *fp;

	//create the vfs file
	fp=fopen(name_with_path,"w");

#ifdef DEBUG	
	if(fp==NULL)
	{
		printf("File could not open\n");
	}
	else
	{
		printf("file opened\n");
	}
#endif


//initialise the header
	int i=0;
	struct Vfs vfs;
struct Vfs_Info vi;
strcpy(vi.Vfs_name,name_with_path);
vi.num_files=0;
struct Vfs_HeaderInfo vh;
vh.vfs_info=vi;
struct Vfs_FileInfo vfile[MAX_FILE];
for( i=0;i<MAX_FILE;i++)
{
	strcpy(vfile[i].fname,"null");
	vfile[i].size=0;
	vh.vfsfiles[i]=vfile[i];
}
vfs.Header=vh;
vfs.Vfs_ptr =fp;
vfs.Vfs_status=1;

#ifdef DEBUG
printf("%ld\n",sizeof(vh));
#endif


//save header at the beginning of vfs file
fwrite(&vfs,sizeof(struct Vfs),1,fp);
#ifdef DEBUG
printf("Done\n");
#endif



// close the file
fclose(fp);

	return 0;
} 
