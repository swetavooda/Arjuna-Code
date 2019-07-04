#include<stdio.h>
int main()
{
    int c,r,i,j,k;
    scanf("%d%d",&r,&c);
    int f[r][c]={0};//giving default values of 0 in final matrix.
	int l[r][c];//matrix of given land by user.
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            scanf("%d",&l[i][j]);
            
        }
    }//end of taking input.
    getchar();
    
    
    /*logic for finding the max square.
		here we are checking for each square taking bottom right of 2x2 square as refernce,and noting max square.
		if i=0 or j=0 then the range goes out of bounds so at i=0 and j=0 we take same values.
		at other positions we check max square that can be formed with the bottom right of square as refecence and store it in 'f' matrix.
		if the value at that index is 0 then we take 0 as the value in final matrix*/

    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            if(i==0||j==0)
            {
                f[i][j]=l[i][j];
                
            }
            else if(l[i][j]==0)
            {
                f[i][j]=0;
                
            }
            else
            {
                int temp[3]={0};
                
                temp[0]=f[i-1][j];
                temp[1]=f[i][j-1];
                temp[2]=f[i-1][j-1];
                int min=temp[0];
                for(k=0;k<3;k++)
                {
                    if(min>temp[k])
                    {
                        min=temp[k];
                    }
                }
                f[i][j]=(min+1);
                
            }
        }
    }//end of logic.
    
    /*finding max square in final matrix.*/
    int max=0;
    for(i=0;i<r;i++)
    {
        for(j=0;j<c;j++)
        {
            if(f[i][j]>max)
            {
                max=f[i][j];
            }
        }
    }
    printf("%d",max);
    
return 0;
}
        
    
    

