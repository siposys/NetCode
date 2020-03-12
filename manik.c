#include <stdio.h>
#include <stdlib.h>
#include <zlib.h>

#define BUF_SIZE 1024
// compress
int compress(Byte *ibuf, Byte *obuf){
	int ret = Z_OK;
    z_stream strm;

        Byte *ibuf, *obuf;
        FILE *ifp = fopen("input.txt", "r");
        FILE *ofp = fopen("output.gz", "w");

        ibuf = (Byte *)calloc(BUF_SIZE, sizeof(Byte));
        obuf = (Byte *)calloc(BUF_SIZE, sizeof(Byte));
        fread(ibuf, BUF_SIZE, 1, ifp);

        strm.zalloc = Z_NULL;
        strm.zfree = Z_NULL;
        strm.opaque = Z_NULL;

        ret = deflateInit2(&strm, 6, Z_DEFLATED, 31, 8, Z_DEFAULT_STRATEGY);

        strm.next_in = ibuf;
        strm.avail_in = BUF_SIZE;
        strm.next_out = obuf;
        strm.avail_out = BUF_SIZE;

        ret = deflate(&strm, Z_FINISH);

        fwrite(obuf, strm.total_out, 1, ofp);

	END:
        deflateEnd(&strm);
        fclose(ofp);
        fclose(ifp);

        return 0;
}
int main(int argc, char **argv)
{
    compress(ibuf, obuf);
	decompress(src, srcLen, dst, dstLen);
}





// Decompress
int decompress(const char *src, int srcLen, const char *dst, int dstLen){
z_stream strm;
strm.zalloc=NULL;
strm.zfree=NULL;
strm.opaque=NULL;

strm.avail_in = srcLen;
strm.avail_out = dstLen;
strm.next_in = (Bytef *)src;
strm.next_out = (Bytef *)dst;

int err=-1, ret=-1;
err = inflateInit2(&strm, MAX_WBITS+16);
if (err == Z_OK){
    err = inflate(&strm, Z_FINISH);
    if (err == Z_STREAM_END){
        ret = strm.total_out;
    }
    else{
        inflateEnd(&strm);
        return err;
    }
}
else{
    inflateEnd(&strm);
    return err;
}
inflateEnd(&strm);
printf("%s\n", dst);
return err;
}
