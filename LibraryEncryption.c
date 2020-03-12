#include <stdio.h>
#include <string.h>  // for strlen
#include <assert.h>
//#include<conio.h>
#include "zlib.h"

 char b[50];
 char c[50];
 
void writeFile(char fileName[], char packet[], int packetSize){	
	FILE *fptr;
	fptr = fopen(fileName,"wb");
	if(fptr!= NULL){
		fwrite(packet, sizeof(char), packetSize, fptr);
		fclose(fptr);
	}else{
		printf("File can't be opened.\n");
	}	
}

/*
string Filename = "BinaryFile.bin";
FILE* pFile;
pFile = fopen(Filename.c_str(), "rb");
fseek(pFile, 0L, SEEK_END);
size_t size = ftell(pFile);
fseek(pFile, 0L, SEEK_SET);
uint8_t* ByteArray;
ByteArray = new uint8_t[size];
if (pFile != NULL)
{
    int counter = 0;
    do {
        ByteArray[counter] = fgetc(pFile);
        counter++;
    } while (counter <= size);
    fclose(pFile);
}
for (size_t i = 0; i < 800; i++) {
    printf("%02X ", ByteArray[i]);
}

*/

//void readFile(char fileName[], char* packet[]){
int readFile(char fileName[]){
	int counter = 0;
	FILE *fp;
	//uint8_t* ByteArray;
	
	fp = fopen(fileName,"rb");
	if(fp!= NULL){
		char c;
		//fseek(fp, 0L, SEEK_END);
		//size_t size = ftell(fp);
		//fseek(fp, 0L, SEEK_SET);
		//ByteArray = new uint8_t[size];
		/*while(fgetc(fp)!=EOF){
			c=fgetc(fp);
			b[counter++] = fgetc(fp);
		}*/
		
		do{
			c=fgetc(fp);
			b[counter] = c;
			counter++;
		}while(c!=EOF);
		//} while (counter <= size);*/
		fclose(fp);
		
	}else{
		printf("File can't be opened.\n");
	}
	return --counter;
}

int main(int argc, char* argv[])
{   

	char a[50] = "Hello Hello Hello Hello Hello Hello!";
    //char b[50];
	//char c[50];

	//uLong ucompSize = strlen(a)+1;
	uLong ucompSize = strlen(a);
	uLong compSize = compressBound(ucompSize);

	// Deflate
	//compress((char*)a, (char*)b);
	//compress((Bytef *)b, &compSize, (Bytef *)a, ucompSize);
	//b=encode(b);
	//writeFile((char*)"Compressed.txt", b, sizeof(b));
	//readFile((char*)"JCompressed.txt", b);
	int counter=readFile((char*)"Compressed.txt");
	printf("File Length: %d ", counter);
	//writeFile((char*)"JJJ.txt", b, counter);
	for(int i = 0; i < counter; i++) {
			printf("%c ", b[i]);
		}
	// Inflate
	uncompress((Bytef *)c, &ucompSize, (Bytef *)b, compSize);
	//decompress((char*)b, (char*)c);
	//printf("Original size is: %lu\n", strlen(a));
    //printf("Original string is: %s\n", a);
	//compress((char*)a, (char*)b);
	//printf("Compressed size is: %lu\n", strlen(b));
    //printf("Compressed string is: %s\n", b);
	//decompress((char*)b, (char*)c);
	printf("Decompressed size is: %lu\n", strlen(c));
    printf("Decompressed string is: %s\n", c);
}	
	