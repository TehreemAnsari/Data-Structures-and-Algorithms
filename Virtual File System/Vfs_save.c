#include"Vfs.h"
extern struct Vfs svfs;
	int vfs_save(char * name, char * name_with_path)
	{

		
		int st=vfs_load(name_with_path);
		if(st==0)
			{
				printf("Vfs opened correclty\n");
			}
			else{
				printf("Vfs not opened\n");
			}
			

			FILE *fp;

	
	fp=fopen(name,"r+");


	if(fp==NULL)
	{
		printf("File could not open\n");
	}
	else
	{
		printf("file opened\n");
	}

int len=0;
char arr;
	
FILE *fp4=svfs.Vfs_ptr;
fseek(fp4,0,SEEK_SET);

	if(svfs.Header.vfs_info.num_files==MAX_FILE){
		printf("You have no more space left.\n");
		return -1;
	}
	
		
int i=0;
	
	int offset=sizeof(struct Vfs);
	while(i<svfs.Header.vfs_info.num_files)
	{
		offset=offset+svfs.Header.vfsfiles[i].size;
		i++;
	}
	fseek(fp4,0,SEEK_SET);
fseek(fp4,offset,SEEK_SET);

len=0;
while(!feof(fp))
{
arr=(char)fgetc(fp);
fwrite(&arr,sizeof(char),1,fp4);
	len++;
}
printf("calculated size: %d\n",len);
fseek(fp4,0,SEEK_SET);

	i=0;
	printf("len: %d\n",len);
	while(i<svfs.Header.vfs_info.num_files)
	{
		i++;
	}
	strcpy(svfs.Header.vfsfiles[i].fname,name);
	svfs.Header.vfsfiles[i].size=len;
	fseek(fp4,0,SEEK_SET);
svfs.Header.vfs_info.num_files=svfs.Header.vfs_info.num_files+1;

printf("%d\n",svfs.Header.vfs_info.num_files);


#ifdef DEBUG
printf("%ld\n",sizeof(svfs));
#endif

fseek(fp4,0,SEEK_SET);

fwrite(&svfs,sizeof(struct Vfs),1,fp4);
#ifdef DEBUG
printf("Done\n");
#endif




fclose(fp4);

fclose(fp);


return 0;
}





















	
