#include <fstream>
#include <iostream>
#include <string>
using namespace std;

void openData(int age, string in_line, int loopNumber)
{
    float *heightTable = new float[10000];
}

int main()
{
    float personalHeight;
    float personalWeight;
    int personalAge;

    float yourHeight;
    float yourWeight;

    int peopleNumber = 10000;
    char answer;

    int loopNumber = 0;
    float heightTable[peopleNumber];
    float weightTable[peopleNumber];
    int ageTable[peopleNumber];

    int rank;

    /*while(1){
    
    //cout << "Input personal age data" << endl;
    //cin >> personalAge;
    cout << "Input personal height data" << endl;
    cin >> personalHeight;
    //cout << "Input personal weight data" << endl;
    //cin >> personalWeight;

    ageTable[loopNumber] = personalAge;
    heightTable[loopNumber] = personalHeight;
    weightTable[loopNumber] = personalWeight;

    cout << "Do you want to quit inputting the data  (y for yes / anything for no)" << endl;
    cin >> answer;
      
      
    if (answer == 'y'){
    cout<<"end"<<endl;
    break;
        }
    

    

    loopNumber = loopNumber + 1;



    }*/

    int ageInput;
    cout << "Select the age that you want to check (ex)17,18,19" << endl;
    cin >> ageInput;

    string in_line;

    switch (ageInput)
    {
        case 17:
        {
            ifstream in("age17.txt");
            for (loopNumber = 0; loopNumber < 576; loopNumber++)
            {
                if (getline(in, in_line))
                {
                    heightTable[loopNumber] = atof(in_line.c_str());
                }
            }
        }
        break;

        case 18:
        {
            ifstream in("age18.txt");
            for (loopNumber = 0; loopNumber < 609; loopNumber++)
            {
                if (getline(in, in_line))
                {
                    heightTable[loopNumber] = atof(in_line.c_str());
                }
            }
        }
        break;

        case 19:
        {
            ifstream in("age19.txt");
            for (loopNumber = 0; loopNumber < 573; loopNumber++)
            {
                if (getline(in, in_line))
                {
                    heightTable[loopNumber] = atof(in_line.c_str());
                }
            }
        }
    }

    int last = loopNumber - 1;
    int current = 0;

    for (int current = 0; current < last; current++)
    {
        for (int walker = last; walker > current; walker--)
            if (heightTable[walker] > heightTable[walker - 1])
            {
                float temp = heightTable[walker];
                heightTable[walker] = heightTable[walker - 1];
                heightTable[walker - 1] = temp;
            }
    }

    cout << "Write your height (cm)" << endl;
    cin >> yourHeight;
    //cout << "Write your weight" << endl;
    //cin >> yourWeight;

    heightTable[loopNumber] = yourHeight;
    weightTable[loopNumber] = yourWeight;

    last = loopNumber;
    current = 0;
    rank = 1;

    for (int current = 0; current < last; current++)
    {
        for (int walker = last; walker > current; walker--)
        {
            if (heightTable[walker] > heightTable[walker - 1])
            {
                float temp = heightTable[walker];
                heightTable[walker] = heightTable[walker - 1];
                heightTable[walker - 1] = temp;
                rank = walker;
            }
        }
    }

    int totalNumber = loopNumber; //totalNumber = 574;

    int yourHeightRank = rank;
    float fracNumber = (float)yourHeightRank / (float)totalNumber;
    float percentile = (float)(fracNumber * 100);
    float highRank_percentile = (float)(100 - percentile);

    for (int i = 0; i <= totalNumber - 1; i++)
    {
        cout << "#" << i + 1 << /*" age: "<< ageTable[i] <<*/ " height: " << heightTable[i] /*<<" / weight: "<<weightTable[i]*/ << endl;
    }
    cout << "your rank is " << yourHeightRank << " (total: " << totalNumber << ")" << endl;
    cout << "The high percentile of your height is " << percentile << "%" << endl;

    return 0;
}