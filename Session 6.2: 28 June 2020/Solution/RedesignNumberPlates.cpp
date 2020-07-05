/*
Redesign Number Plates :

The Mayor of Rome City has decided to abolish using English numerals for all Door & Street numbers in the city. 
He wants to popularize Roman Numerals and to that effect he passed an order to replace all street and door numbers 
with roman numerals. Roman numerals are a combination of standard symbols like (I, V, X, L, C). 

The Mayor wants the roman digits be cut from rectangular brass block of standard size. 
From a brass block, we can cut either 6 of (I or L) or 4 of (X or V or C) digits.
As a pilot project, he wants to try out with a few selected streets to find out total number of roman digits 
needed to replace all English numbers with Roman numbers and also the number of brass blocks needed.

Write a program to read the range of street numbers i.e., start street number and end street number (in English form) and 
1. Determine the total number of each roman digit i.e., total number of Iâ€™s, Vâ€™s, Xâ€™s, Lâ€™s and Câ€™s, 
need to for street numbers between start and end street number (including both). 
Display the total of each roman digit in separate line followed by the total number of brass plates needed 
for all roman digits. 
2. For any erroneous input, display invalid input followed input values.

Sample Input :
10 15

Sample Output :
I 7
V 2
X 6
L 0
C 0
TP 5

Sample Input 2:
10 5
Sample Output 2:
invalid input 10 5


case = 1

input =5 5
output = I 0
V 1
X 0
L 0
C 0
TP 1

case = 2
input =5 10
output = I 7
V 4
X 2
L 0
C 0
TP 4

case = 3
input =-1 10
output = invalid input -1 10

case = 4
input =30 50
output = I 28
V 10
X 42
L 11
C 0
TP 20

case = 5
input =19 37
output = I 25
V 9
X 47
L 0
C 0
TP 19



*/


#include <cstdio>
#include <iostream>
#define maxN 100
using namespace std;

struct Numbers {
    int i, v, x, l, c;
};
Numbers numbers[maxN];
int total_plates=0;
void convertoroman(int from ,int to) {
    numbers[1].i = 0;
    numbers[1].v = numbers[1].x = numbers[1].l = numbers[1].c = 0;
    for (int i = from; i <= to; i++) {
        numbers[i] = numbers[i-1];
        int n = i, pos = 0, digit;
        digit = n % 10; n /= 10;
        if (digit == 4) {
            numbers[i].i++;
            numbers[i].v++;
        }
        else if (digit == 9) {
            numbers[i].i++;
            numbers[i].x++;
        }
        else {
            numbers[i].i += digit % 5;
            numbers[i].v += digit / 5;
        }
        if (!n) continue;
        digit = n % 10; n /= 10;
        if (digit == 4) {
            numbers[i].x++;
            numbers[i].l++;
        }
        else if (digit == 9) {
            numbers[i].x++;
            numbers[i].c++;
        }
        else {
            numbers[i].x += digit % 5;
            numbers[i].l += digit / 5;
        }
    }
   
}


void determine_plates_required(int tot_il_digits,int tot_xvc_digits) {
    
	total_plates = (tot_il_digits / 6) + (tot_il_digits % 6 ? 1 : 0)  +  (tot_xvc_digits / 4) + (tot_xvc_digits % 4 ? 1 : 0);

}



int main() {
 int from,to,tot_il,tot_xvc;
    	scanf("%d %d", &from,&to);
    if((from > to) || (from <0) || (to<0)){
        printf("invalid input %d %d",from,to);
        return 0;
    }
    	convertoroman(from,to);
	tot_il=numbers[to].i+numbers[to].l;
	tot_xvc=numbers[to].x+numbers[to].v+numbers[to].c;
	determine_plates_required(tot_il,tot_xvc);
    //printf("%d %d",tot_il,tot_xvc);

	printf("I %d\n", numbers[to].i);
	printf("V %d\n", numbers[to].v);
	printf("X %d\n", numbers[to].x);
	printf("L %d\n", numbers[to].l);
	printf("C %d\n", numbers[to].c);
	printf("TP %d\n", total_plates);
	return 0;
}


