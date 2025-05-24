#include <bits/stdc++.h>
using namespace std;

class AbstractEngine {
    private:
    int stroke;
    public:
    AbstractEngine() = default;
    AbstractEngine(int stroke):stroke(stroke){}
    virtual void pureFun() = 0;
};

class Engine:public AbstractEngine{
  private:
  const int stroke; // const variables must be initialized
  string &manufacturerRef; // References must be initialized
  public:
  static string manufacturer;
  Engine():stroke(0),manufacturerRef(manufacturer){} // Default initializer list
  Engine(int stroke):stroke(stroke),manufacturerRef(manufacturer){} // parameterized Initializer list Constructor
  virtual void show(){
      cout<<"Engine is "<<this->stroke<<" stroke, Manufactured by: "<<this->manufacturerRef<<endl;
  }
  int getStroke(){
      return this->stroke;
  }
  string& getManufacturer(){
      return this->manufacturerRef;
  }
  void pureFun() override{
    cout<<"Pure Functions must be implemented in Derived Class"<<endl;
}
};

string Engine::manufacturer = "Unknown"; // all static variables must be initialized

class Car:public Engine{
    private:
    Engine *carEngine;
    public:
    Car(){
        cout<<"Car class is called ()"<<endl;
        carEngine = new Engine();
    }
    Car(int stroke){
        carEngine = new Engine(stroke);
    }
    void show() override {
        cout<<"Car's Engine is "<<this->carEngine->getStroke()<<" stroke, Manufactured by: "<<this->carEngine->getManufacturer()<<endl;
    }
};

int main() {
    
    // Static Object Creation
    Engine e; e.show();
    // Accessing Static values of class
    Engine::manufacturer = "Toyota";
    // Dynamic Object Creation
    Engine *e2 = new Engine(4); e2->show(); e2->pureFun();
    Car c; c.show();
    return 0;
}

/* OUTPUT

Engine is 0 stroke, Manufactured by: Unknown
Engine is 4 stroke, Manufactured by: Toyota
Pure Functions must be implemented in Derived Class
Car class is called ()
Car's Engine is 0 stroke, Manufactured by: Toyota

*/