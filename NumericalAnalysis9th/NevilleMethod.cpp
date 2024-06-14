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


//## Out the table.

}