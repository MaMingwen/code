#include <iostream>

void foo() {
    throw std::runtime_error("An exception occurred in foo()");
}

int main() {
    try {
        std::cout << "Before calling foo()." << std::endl;
        foo();
        std::cout << "After calling foo()." << std::endl; // This line won't execute
    } catch (const std::exception& e) {
        std::cerr << "Caught exception: " << e.what() << std::endl;
    }
    return 0;
}