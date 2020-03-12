#include <stdio.h>
#include <string.h>  // for strlen
#include <assert.h>
//#include<conio.h>
#include "zlib.h"

//void WriteFile(char* FileName, char* packet){
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

void homeCompress(char input[], char output[], uInt size){
	int compressedLength=0;
	size_t blockSize=50;
	z_stream defstream;
	
	int deflateInitiazed=deflateInit2(&defstream, Z_DEFAULT_COMPRESSION, Z_DEFLATED, MAX_WBITS+16, 9, Z_DEFAULT_STRATEGY);
	printf("The Deflate Initialization Value: %d\n", deflateInitiazed);
	
    defstream.zalloc = Z_NULL;
    defstream.zfree = Z_NULL;
    defstream.opaque = Z_NULL;
	defstream.next_in = (Bytef *)input;
    //defstream.avail_in = (uInt)sizeof(input);
	defstream.avail_in =size;
	printf("The Original String Length: %d\n", strlen(input));
    do{
		defstream.avail_out = blockSize;
		defstream.next_out = (Bytef *)(&output[0]+compressedLength);
		int deflateStatus=deflate(&defstream, Z_FINISH);
		printf("The Deflate Status: %d\n", deflateStatus);
		switch(deflateStatus){
			case -5:
				printf("Compression Error: Z_BUF_ERROR\n");
				break;
			case -4:
				printf("Compression Error: Z_MEM_ERROR\n");
				break;
			case -2:
				printf("Compression Error: Z_STREAM_ERROR\n");
				break;
			case 1:
				printf("Compression Success: Z_STREAM_END\n");
				break;
			case 0:
				printf("Compression Success: Z_OK\n");
				break;
		}
		compressedLength+=(blockSize-defstream.avail_out);
	}while(defstream.avail_out==0);
    
	//deflateEnd(&defstream);
}
void homeUncompress(char input[], char output[], uInt size){
	int compressedLength=0;
	size_t blockSize=50;
	z_stream infstream;	
	
	int inflateInitiazed=inflateInit2(&infstream, MAX_WBITS+32);
	printf("The Inflate Initialization Value: %d\n", inflateInitiazed);
	
	infstream.zalloc = Z_NULL;
	infstream.zfree = Z_NULL;
	infstream.opaque = Z_NULL;
	
	//infstream.avail_in = (uInt)sizeof(input);	
	infstream.avail_in = size;	
	infstream.next_in = (Bytef *)input;
	do{
		infstream.avail_out = blockSize;
		infstream.next_out = (Bytef *)(&output[0]+compressedLength);
		int inflateStatus=inflate(&infstream, Z_FINISH);
		printf("The Inflate Status: %d\n", inflateStatus);
		compressedLength+=(blockSize-infstream.avail_out);
	}while(infstream.avail_out == 0);
	
	//inflateEnd(&infstream);
}	


int main(int argc, char* argv[])
{   

	char a[50] = "Hello Hello Hello Hello Hello Hello!Hello Hello H";
    char b[50];
	char c[50];
	char* ba;
	//uLong ucompSize = strlen(a)+1; // "Hello, world!" + NULL delimiter.
	//uLong compSize = compressBound(ucompSize);

	// Deflate
	homeCompress(a, b, 50);
	homeUncompress(b, c, 50);
	//homeUncompress((char*)b, (char*)c, strlen(b));
	//compress2((Bytef *)b, &compSize, (Bytef *)a, ucompSize, 9);
	//b=encode(b);
	
	// Inflate
	//uncompress((Bytef *)c, &ucompSize, (Bytef *)b, compSize);
	writeFile((char*)"a.txt", a, strlen(a));
	writeFile((char*)"b.txt", b, strlen(b));
	writeFile((char*)"c.txt", c, strlen(c));
	
	printf("Original size is: %lu\n", strlen(a));
    printf("Original string is: %s\n", a);
	
	printf("Compressed size is: %lu\n", strlen(b));
    printf("Compressed string is: %s\n", b);
	
	printf("Decompressed size is: %lu\n", strlen(c));
    printf("Decompressed string is: %s\n", c);
}	
	