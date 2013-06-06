public class MuConverttimeTest {
	

public String test1()
{
GPXtime time = GPXtime.createGPXtime("1970-01-02T00:00:00Z");
if (time!=null)
return (Long.toString(time.convertToJavaTime()));
else
return "null";
}

public String test2()
{
GPXtime time = GPXtime.createGPXtime("1973-01-01T00:00:00Z");
if (time!=null)
return (Long.toString(time.convertToJavaTime()));
else
return "null";
}

public String test3()
{
GPXtime time = GPXtime.createGPXtime("2000-01-01T00:00:00Z");
if (time!=null)
return (Long.toString(time.convertToJavaTime()));
else
return "null";
}

public String test4()
{
GPXtime time = GPXtime.createGPXtime("1970-01-01T00:00:00Z");
if (time!=null)
return (Long.toString(time.convertToJavaTime()));
else
return "null";
}

public String test5()
{
GPXtime time = GPXtime.createGPXtime("GPX");
if (time!=null)
return (time.toString());
else
return "null";
}
}