// C++ program to get least cost path in a grid from 
#include <bits/stdc++.h> 
using namespace std; 
int n;
int ROW;
int COL;
int sorted[100][3];
int grid[200]={0};
// structure for information of each cell 
struct cell 
{ 
	int x, y; 
	int distance; 
	cell(int x, int y, int distance) : 
		x(x), y(y), distance(distance) {} 
}; 

// Utility method for comparing two cells 
bool operator<(const cell& a, const cell& b) 
{ 
	if (a.distance == b.distance) 
	{ 
		if (a.x != b.x) 
			return (a.x < b.x); 
		else
			return (a.y < b.y); 
	} 
	return (a.distance < b.distance); 
} 
// Utility method to check whether a point is 
// inside the grid or not 
bool isInsideGrid(int i, int j) 
{ 
	return (i >= 0 && i < COL && j >= 0 && j < ROW); 
} 

// Method returns minimum cost to reach bottom 
int shortest(int n,int prevr,int prevc,int r, int c) 
{ 
	//cout<<"hello"<<grid[0][0];//
	//cout<<*(*(g+0)+0);
	for(int i=0;i<n;i++)
	{
		for(int j=0;j<n;j++)
		{
			//cout<<*(*(g+i)+j)<<"  ";
		}
		//cout<<endl;
	}
	int col=n,row=n;
	int dis[row][col]; 

	// initializing distance array by INT_MAX 
	for (int i = 0; i < row; i++) 
		for (int j = 0; j < col; j++) 
			dis[i][j] = INT_MAX; 

	// direction arrays for simplification of getting 
	// neighbour 
	int dx[] = {-1, 0, 1, 0}; 
	int dy[] = {0, 1, 0, -1}; 

	set<cell> st; 

	// insert (0, 0) cell with 0 distance 
	st.insert(cell(prevr, prevc, 0)); 

	// initialize distance of (0, 0) with its grid value 
	dis[prevr][prevc] = grid[0]; 
	//cout<<"1 ans";
	
	// loop for standard dijkstra's algorithm 
	while (!st.empty()) 
	{ 
	
		// get the cell with minimum distance and delete 
		// it from the set 
		cell k = *st.begin(); 
		st.erase(st.begin()); 

		// looping through all neighbours 
		for (int i = 0; i < 4; i++) 
		{ 
	
			int x = k.x + dx[i]; 
			int y = k.y + dy[i]; 

			// if not inside boundary, ignore them 
			if (!isInsideGrid(x, y)) 
				continue;
		 

			// If distance from current cell is smaller, then 
			// update distance of neighbour cell 
			if (dis[x][y] > dis[k.x][k.y] + grid[(x*n)+y]) 
			{ 
				// If cell is already there in set, then 
				// remove its previous entry 
				if (dis[x][y] != INT_MAX) 
					st.erase(st.find(cell(x, y, dis[x][y]))); 

				// update the distance and insert new updated 
				// cell in set 
				dis[x][y] = dis[k.x][k.y] + grid[(x*n)+y]; 
				st.insert(cell(x, y, dis[x][y])); 
			} 
		} 
	} 

	// uncomment below code to print distance 
	// of each cell from (0, 0) 
	/* 
	for (int i = 0; i < row; i++, cout << endl) 
		for (int j = 0; j < col; j++) 
			cout << dis[i][j] << " "; 
	*/
	// dis[row - 1][col - 1] will represent final 
	// distance of bottom right cell from top left cell 
	return dis[r][c]; 
} 

// Driver code to test above methods 
void sort(int pos[][3],int r)
{
	int i,j;
	//int *temp[3];
	//cout<<"pos";
	int count=r;
	int l=0;
	int last=-1;
	int min;
	while(count--)
	{
	
	min=1000;
	for(i=0;i<r;i++)
	{
		if(pos[i][0]<min && pos[i][0]>last)
		{
			min=pos[i][0];
		}
	}
	last=min;
	for(i=0;i<r;i++)
	{
		if(pos[i][0]==last)
		{
			sorted[l][0]=last;
			sorted[l][1]=pos[i][1];
			sorted[l++][2]=pos[i][2];
	}
}
}
}
// Driver code to test above methods 
int main() 
{ 
	cin>>n;
	ROW=n;
	COL=n;
	int given[n*n];
	int r=0,i,j;
	for(i=0;i<n*n;i++)
	{
		cin>>given[i];
		if(given[i]==0)
		{
			grid[i]=1000;
			
		}
		else
		{
			grid[i]=1;
		}
		
	}
	
	int positionfor[n*n]={0};
	
	int pos[n][3];
	int ind;
	for(i=0;i<n*n;i++)
	{
			if(given[i]!=0 && given[i]!=1)
			{
				pos[r][0]=given[i];
				ind=i/n;
				pos[r][1]=ind;
				pos[r++][2]=i-(n*ind);
			}
			
		}

	sort(pos,r);
	int answer;
	answer=shortest(n,0,0,sorted[0][1],sorted[0][2])-1;
	for (i=1;i<r;i++)
	{
		int R=sorted[i][1];
		int C=sorted[i][2];
		answer+=shortest(n,sorted[i-1][1],sorted[i-1][2], R, C)-1; 
	}
	if (answer>1000)
	cout<<-1;
	else
	cout<<answer;
	return 0; 
} 
