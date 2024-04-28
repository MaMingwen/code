// 具体意思不太懂，大概是在"test exception"被caught前cout了g，此时uncaught_exceptions()为一，因为"test exception"还未被捕捉。在"test exception"被caught被caught后cout了f，此时uncaugth_exceptions()为零，此时"test exception"已经被捕捉。
#include <exception>
#include <iostream>
#include <stdexcept>
 
struct Foo
{
    char id{'?'};
    int count = std::uncaught_exceptions();//count是类初始化时，uncaught_exceptions的数量。
 
    ~Foo()
    {
        count == std::uncaught_exceptions()
            ? std::cout << id << ".~Foo() called normally\n"
            : std::cout << id << ".~Foo() called during stack unwinding\n";
    }
};
 
int main()
{
    Foo f{'f'};
 
    try
    {
        Foo g{'g'};
        std::cout << "Exception thrown\n";
        throw std::runtime_error("test exception");
    }
    catch (const std::exception& e)
    {
        std::cout << "Exception caught: " << e.what() << '\n';
    }
}