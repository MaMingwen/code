/*
# (Textbook's Page 123) Neville's Iterated Interpolation
## Input
1. Numbers $x, x_0, x_1, \cdots, x_n$.
2. Values $f(x_0), f(x_1), \cdots, f(x_n)$.

## Output
1. The corresponding Neville's table.

## Data structure
1. Vectors
*/

#include <iostream>
#include <string>
#include <vector>

int main(){

//Read from inputs.

int n = 0; //The number of given values.
double a; //The number at which we want estimate the corresponding value.

std::string xi; //dummy variable. 
std::vector<double> x;

std::string fi; //dummy variable.
std::vector<double> f;

std::cout<<"Please enter the number a:";
std::cin>>a;

std::cout<<"Please enter the numbers x_0,x_1,...,x_n:"<<std::endl;
while(true){
    std::cin>>xi;
    if(std::stod(xi)){
    x.push_back(std::stod(xi));
    n++;
    }
    else{
        break;
    }
}

std::cout<<"Please enter the values f(x_0),f(x_1),...,f(x_n):"<<std::endl;
while(true){
    std::cin>>fi;
    if(std::stod(fi)){
    f.push_back(std::stod(fi));
    }
    else{
        break;
    }
}

//Calculate.

//Out the table.
std::cout << a << std::endl;
}