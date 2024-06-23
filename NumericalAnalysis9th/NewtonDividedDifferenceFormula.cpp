/*
# Newton's Divided-Difference Formula

## Input
numbers $x_0,x_1,\cdots,x_n$; values $f(x_0),f(x_1),\cdots,f(x_n)$.

## Output
1. a talbe where the divided differences are outlined.
2. a polynomial.

## Data structure
1. vector

## Others
1. 如何遍历：先从列指标 $j$ 开始遍历。
*/

#include <iostream>
#include <vector>

int main(){
//Input
//In fact, almost all of interpolating algorithms share the same input codes.

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


//Calculate



//Output



}