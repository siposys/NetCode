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

int main(int argc, char* argv[])
{ 
	char a[50] = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	char b[50];
	char c[50];

	// deflate
	// zlib struct
	z_stream defstream;
	defstream.zalloc = Z_NULL;
	defstream.zfree = Z_NULL;
	defstream.opaque = Z_NULL;
	defstream.avail_in = (uInt)strlen(a)+1; // size of input, string + terminator
	defstream.next_in = (Bytef *)a; // input char array
	defstream.avail_out = (uInt)sizeof(b); // size of output
	defstream.next_out = (Bytef *)b; // output char array

	deflateInit2(&defstream, Z_DEFAULT_COMPRESSION);
	deflate(&defstream, Z_FINISH);
	deflateEnd(&defstream);

	// This is one way of getting the size of the output
	//printf("Deflated size is: %lu\n", (char*)defstream.next_out - b);

	// inflate
	// zlib struct
	z_stream infstream;
	infstream.zalloc = Z_NULL;
	infstream.zfree = Z_NULL;
	infstream.opaque = Z_NULL;
	infstream.avail_in = (uInt)((char*)defstream.next_out - b); // size of input
	infstream.next_in = (Bytef *)b; // input char array
	infstream.avail_out = (uInt)sizeof(c); // size of output
	infstream.next_out = (Bytef *)c; // output char array

	inflateInit2(&infstream);
	inflate(&infstream, Z_NO_FLUSH);
	inflateEnd(&infstream);

	//printf("Inflate:\n%lu\n%s\n", strlen(c), c);
	
	writeFile((char*)"mk_a.txt", a, strlen(a));
	writeFile((char*)"mk_b.txt", b, strlen(b));
	writeFile((char*)"mk_c.txt", c, strlen(c));
	
	printf("Original size is: %lu\n", strlen(a));
    printf("Original string is: %s\n", a);
	
	printf("Compressed size is: %lu\n", strlen(b));
    printf("Compressed string is: %s\n", b);
	
	printf("Decompressed size is: %lu\n", strlen(c));
    printf("Decompressed string is: %s\n", c);
}