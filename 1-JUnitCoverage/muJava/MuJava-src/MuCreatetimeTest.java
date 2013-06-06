public class MuCreatetimeTest {
	
public String test1()
{
GPXtime time = GPXtime.createGPXtime("2011-10-17T13:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
}

public String test2()
{
GPXtime time = GPXtime.createGPXtime("#$@%^g2");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test3()
{
GPXtime time = GPXtime.createGPXtime("1969-11-17T11:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test4()
{
GPXtime time = GPXtime.createGPXtime("1971-00-17T11:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test5()
{
GPXtime time = GPXtime.createGPXtime("1971-13-17T11:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test6()
{
GPXtime time = GPXtime.createGPXtime("1971-11-00T11:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test7()
{
GPXtime time = GPXtime.createGPXtime("1971-11-32T11:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 

public String test8()
{
GPXtime time = GPXtime.createGPXtime("1971-11-17T-1:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 

public String test9()
{
GPXtime time = GPXtime.createGPXtime("1971-11-17T25:11:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 

public String test10()
{
GPXtime time = GPXtime.createGPXtime("1971-11-17T11:-1:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 

public String test11()
{
GPXtime time = GPXtime.createGPXtime("1971-11-17T11:61:11Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 

public String test12()
{
GPXtime time = GPXtime.createGPXtime("1969-19-17T11:11:-1Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 

public String test13()
{
GPXtime time = GPXtime.createGPXtime("1969-19-17T11:11:61Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
}