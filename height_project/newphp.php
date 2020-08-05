<?php include 'database.php'; ?>


<?php 
    $query = "SELECT * FROM height_object WHERE age = 15";
    $height = mysqli_query($con, $query);
    ?>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width">
        <title>Height Ranking</title>
        <link href="style.css" rel="stylesheet" type="text/css" />
        <style>
        
        .title{
            font-size: 65px;
            text-align: center;
            padding-top: 50px;
        }

        .subtitle{
            font-size: 30px;
            text-align: center;
            padding-top: 10px;
            color: #3a3a4b;
        }

        .personal_input{
            display: flex;
            padding-top: 130px;
            font-size: 25px;
            margin:0 auto;;
        }

        .sex_select{
            padding-left: 450px;
            
        }
        
        .age_height{
            padding-left: 390px
        }

        .run_check{
            border: none;
            color: white;
            background-color: blueviolet;
            margin: auto;
            height: 35px;
            width: 50px;
            border-radius: 6px;
        }
        




        </style>
    </head>
    <body style="background-color: #3a3a4b; color: aliceblue;">
       <div class="nav">
           ver.prototype
       </div> 
       <div class="main">
           <div class="title">
               Height Ranking
           </div>
           <div class="subtitle">
               나의 키는 상위 몇 %일까?
           </div>
           <div class="personal_input">
            <div class="sex_select" id="sexSelect" value="0">
                <input type="radio" id="male" name="gender" value="1">
                남자<br>
                <input type="radio" id="female" name="gender" value="2">
                여자
            </div>
            <form class="age_height">
                <label for="age" style="padding-right: 1px;">나이&nbsp;</label><input type="text" id="age" name="personal_age" style="width: 100px; height: 20px; padding-top: 6px;" ><br>
                <label for="height">키&nbsp;&nbsp;&nbsp;&nbsp;</label><input type="text" id="height" name="personal_height" style="width: 100px; height: 20px; padding-top: 6px;">
            </form>           
            </div>
            <div style="text-align: center; padding-top: 100px;">
                <button class="run_check" type="button" id="checkButton" onclick="getInput(); buttonChange(); showChart();">
                    check
                </button>

                

            </div>
            <script>
                var age;
                var height;
                var maleCheck;
                var femaleCheck;
                var sex;

                function buttonChange(){
                    var elem = document.getElementById("checkButton");
                    
                    if (elem.innerText=="check") {
                        elem.innerText = "cancel";
                        document.getElementById("demo").innerText = sex + " / " + age + " / "+ height;
                        document.getElementById("demo").style.color = "red";
                        document.getElementById("demo").style.display = "block";
                        document.getElementById("curve_chart").style.display = "block";
                        }
                    else {
                        elem.innerText = "check";
                        document.getElementById("demo").style.display = "none";
                        document.getElementById("curve_chart").style.display = "none";
                        }
                }

                function getInput(){
                    age = document.getElementById("age").value;
                    height = document.getElementById("height").value;
                    maleCheck = document.getElementById("male").checked;
                    femaleCheck = document.getElementById("female").checked;

                    if(maleCheck == true){
                        sex="male";
                    }
                    else if(femaleCheck == true){
                        sex="female";
                    }

                }
                
                </script>
                
                <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
                <script type="text/javascript">
                 function showChart(){
                 google.charts.load('current', {'packages':['corechart']});
                  google.charts.setOnLoadCallback(drawChart);
            
                  function drawChart() {
                    var data = google.visualization.arrayToDataTable([
                      ['Height (cm)', 'People'],
                      ['161',  10],
                      ['164',  20],
                      ['177',  45],
                      ['180',  75],
                      ['183',  110],
                      ['186',  160],
                      ['189',  110],
                      ['191',  75],
                      ['193',  45],
                      ['194',  20],

                    ]);
            
                    var options = {
                      title: 'Height Graph',
                      curveType: 'function',
                      legend: { position: 'bottom' }
                    };

                    
                    var chart = new google.visualization.LineChart(document.getElementById('curve_chart'));
            
                    chart.draw(data, options);
                  }}
                </script>

            <p id="demo" style="text-align: center;"></p>
            <div id="curve_chart" style="width: 900px; height: 500px; margin: auto;"></div>
       </div>
    </body>
</html>
