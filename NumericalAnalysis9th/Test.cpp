// Test the property of 'std::cin' function.
// 
#include <iostream>
#include <string>

int main(){
    std::string s;
    int n;
    while(std::cin>>n){
        std::cout<<"input is an int."<<std::endl;
        std::cout<<n<<std::endl;
    }
    std::cout<<n<<1<<std::endl;
    std::cin.clear();
    std::cin.ignore();
    std::cin>>n;
    std::cout<<n<<std::endl;
}