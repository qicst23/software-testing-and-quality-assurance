public class MuGPXtimeTest {
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
GPXtime time = GPXtime.createGPXtime("2011-02-30T01:01:01Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test3()
{
GPXtime time = GPXtime.createGPXtime("1969-00-00T-1:-1:-1Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test4()
{
GPXtime time = GPXtime.createGPXtime("2011-13-33T25:61:61Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test5()
{
GPXtime time = GPXtime.createGPXtime("1970-01-02T00:00:00Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test6()
{
GPXtime time = GPXtime.createGPXtime("1973-01-01T00:00:00Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 
public String test7()
{
GPXtime time = GPXtime.createGPXtime("2011-02-30T01:01:01Z");
if (time!=null)
return (Integer.toString(time.year())+Integer.toString(time.month())+Integer.toString(time.day())+Integer.toString(time.hour())+Integer.toString(time.minute())+Integer.toString(time.second())+time.toString());
else
return "null";
} 

}