/*
 * Created by User: petervosburgh
 * Date: 9/18/24
 * Time: 7:28 AM
 * 
 */
function Test1()
{
  configObject();

  function configObject()
  {
    console.log( "In Config");
    show();
  }

  function show()
  {
    console.log( "In show");
  }
} // end Test1

export default Test1;