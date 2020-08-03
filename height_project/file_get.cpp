#include <fstream>
#include <iostream>
#include <string>
using namespace std;

int main(){
    string in_line;
	ifstream in("test.txt");
    float height[600];
	while(getline(in,in_line)){

    for(int i=0; i<572; i++){	
	 height[i]= atof(in_line.c_str());
    cout << height[i] << endl;
     }
	
    // 123
    //    cout << in_line << endl;
	}
	in.close();
return 0;
}
