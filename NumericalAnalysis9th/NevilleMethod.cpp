/*
# (Textbook's Page 123) Neville's Iterated Interpolation
## Input
1. Numbers $x, x_0, x_1, \cdots, x_n$.
2. Values $f(x_0), f(x_1), \cdots, f(x_n)$.

## Output
1. The corresponding Neville's table.

## Data structure
1. Vectors

## Fixed bugs
1. After terminating a cin stream, the program can't excute second cin. The reason is that cin stream is under 'fail state' or read a false input or end-of-file.
2. The Neville's formula was printed wrong, I have fixed it.
3. Node method to fix bugs.
*/

#include <iostream>
#include <string>
#include <vector>

int main(){

//## Read from inputs.

int n = 0; //The number of given values.
double a; //The number at which we want estimate the corresponding value.

double xi; //dummy variable. 
std::vector<double> x;

double fi; //dummy variable.
std::vector<double> f;

std::cout<<"Please enter the number a:";
std::cin>>a;

std::cout<<"Please enter the numbers x_0,x_1,...,x_n. Terminate by inputing 'z'."<<std::endl;
while(std::cin>>xi){
    x.push_back(xi);
    n++;
}
std::cout<<n<<std::endl;

//The order of the following statements can't be changed.
std::cin.clear();//fix the first bug.
std::cin.ignore();//fix the first bug.

std::cout<<"Please enter the values f(x_0),f(x_1),...,f(x_n):"<<"There are "<<n<<" values."<<std::endl;

for(int i = 0;i<n;i++){
    std::cin>>fi;
    f.push_back(fi);
}


//## Calculate.
//### Create a matrix, and calculate the corresponding values.
std::vector<std::vector<double>> table(n,std::vector<double>(n+1,0.0));
//### The first column is x_i, i = 0,...,n
for(int i = 0;i<n;i++){
    table[i][0] = x[i];
}

//### The second column is f(x_i), i = 0,...n
for(int i = 0;i<n;i++){
    table[i][1] = f[i];
}

//### Use Neville Method to calculate the matrix
//#### 这个公式市是错的table[i][j] = (a - table[i][0])/(table[i-1][0] - table[i][0])table[i-1][j-1] + (a - table[i-1][0])/(table[i][0] - talbe[i-1][0])table[i][j-1] i = 1,...,n;j = 2,...n.

//dummy = (a - table[1][0])/(table[0][0] - table[1][0])*table[0][1] + (a - table[0][0])/(table[1][0] - table[0][0])*table[1][1];

//talbe[1].push_back(dummy);
for(int i = 1;i<n;i++){
    for(int j = 2;j<=i+1;j++){
        table[i][j] = (a - table[i][0])/(table[i-j+1][0] - table[i][0])*table[i-1][j-1] + (a - table[i-j+1][0])/(table[i][0] - table[i-j+1][0])*table[i][j-1];
    }
}
//## Out the table.
for(int i = 0;i<n;i++){
std::cout << "The " << i+1 << "st row: ";
    for(int j = 0;j<=i+1;j++){
    std::cout << " "<<table[i][j]<<" ";
}
std::cout<<std::endl;
}

std::cout<<"done!"<<std::endl;

std::cout<<"Test";

}