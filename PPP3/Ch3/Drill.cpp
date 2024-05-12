/*
1. First error: 直接将输入赋值给整数变量，这样的话，如果输入不是整数(I)，会出现意想不到的情形:)。
2. 找最大值和最小值时，初始化的问题。
*/
#include <iostream>
#include <string>
#include <limits>
#include <vector>

double convertToMeters(double value, std::string unit){
    if(unit == "cm")
        return value/100.0;
    else if(unit == "in")
        return value * 0.0254;
    else if(unit == "ft")
        return value*0.308;
    else if(unit == "m")
        return value;
    else{
        std::cout<<"Invalid unit:"<<unit<<std::endl;
        return 0.0;
    }
}

int main(){
    double smallest = std::numeric_limits<double>::max();
    double largest = std::numeric_limits<double>::min();
    double temp;
    double sum = 0;
    std::string input1;
    std::string unit;
    std::cout<<"Please enter one number with an unit(cm,m,in,ft): ";
    while(std::cin>>temp>>unit){
        if(convertToMeters(temp,unit)<=smallest){
            smallest = temp;
            sum += temp;
            std::cout<<"The smallest number so far is: "<<temp<<unit<<std::endl;
        }
        else if(convertToMeters(temp,unit)>=largest){
            largest = temp;
            sum += temp;
            std::cout<<"The largest number so far is: "<<temp<<unit<<std::endl;
        }
    }
    std::cout<<"The largest number is: "<<largest<<" m"<<std::endl;
    std::cout<<"The smallest number is: "<<smallest<<" m"<<std::endl;
    std::cout<<"The sum is: "<<sum<<" m"<<std::endl;
    return 0;
}