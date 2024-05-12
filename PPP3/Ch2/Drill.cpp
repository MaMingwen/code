#include <string>
#include <iostream>
#include <exception>

int main()
{
    std::cout<<"Please enter the name of the person you want to write to (followed by \"enter\"):\n";
    std::string first_name;
    std::cin>>first_name;
    std::string friend_name;
    std::cout<<"Please enter the name of another friend:\n";
    std::cin>>friend_name;
    int age;
    std::cout<<"Please enter the age of the recipient:\n";
    std::cin>>age;
    try{
        if(age<=0||age>110){
            throw std::out_of_range("You are kidding!");
        }
        std::cout<<"Dear "<<first_name<<",\n";
        std::cout<<"  How are you? I am fine. I miss you.\n";
        std::cout<<"Recently, I have a cold. And I felt very bad last night. ";
        std::cout<<"Have you seen "<<friend_name<<" lately? ";
        std::cout<<"I hear you just had a birthday and you are "<<age<<" years old. \n";
        if(age<12){
            std::cout<<"Next year you will be "<<age+1;
        }
        else if(age == 17){
            std::cout<<"Next year you will be able to vote";
        }
        else if(age>70){
            std::cout<<"Are you retired?";
        }
        std::cout<<"\nYours sincerely,\n\n"<<"Ken";
    }
    catch(std::out_of_range e){
        std::cout<<e.what();
    }
}