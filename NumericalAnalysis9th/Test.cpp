// Test the property of 'std::cin' function.
#include <iostream>
#include <string>

int main(){
    std::string s;
    int n;
    if(std::cin>>n){
        std::cout<<"input is an int.";
    }
    if(std::cin>>s){
        std::cout<<"input is a string.";
    }
    std::cout<<n<<std::endl;
    std::cout<<s;
}