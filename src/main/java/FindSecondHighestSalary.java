import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class FindSecondHighestSalary {
    public static void main(String[] args) throws FileNotFoundException {
        String line = "";
        String splitBy = ",";
        List<Employee> employees = new ArrayList<>();
        try
        {
            //parsing a CSV file into BufferedReader class constructor
            BufferedReader br = new BufferedReader(new FileReader("/Users/cenkakdeniz/Desktop/notes/data_toptal.csv"));
            while ((line = br.readLine()) != null)   //returns a Boolean value
            {
                String[] employee = line.split(splitBy);    // use comma as separator
                int id = Integer.valueOf(employee[0]);
                String name = employee[1];
                int salary = Integer.valueOf(employee[2]);
                int managerId = -1;
                if(!employee[3].equals("NULL")){
                    managerId = Integer.valueOf(employee[3]);
                }
                employees.add(new Employee(id,name,salary,managerId));
                //System.out.println("Employee [First Name=" + employee[0] + ", Last Name=" + employee[1] + ", Designation=" + employee[2] + ", Contact=" + employee[3] + ", Salary= " + employee[4] + ", City= " + employee[5] +"]");
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        for(Employee e : employees){
            System.out.println(e.toString());
        }

        Employee [] empArray = new Employee[employees.size()];
        Employee [] empWithoutNull = new Employee[employees.size()];
        employees.toArray(empArray);
        for (int i=0; i<empArray.length; i++){
            var emp = empArray[i];
            if(emp.getManagerId()==-1){
                var empNext = empArray[i+1];
                emp.setManagerId(empNext.getManagerId());
            }
            empArray[i] = emp;
        }
        Map<Integer, List<Employee>> groupedEmployees  = Arrays.asList(empArray).stream().collect(Collectors.groupingBy(e -> e.getManagerId()));
        //groupedEmployees.entrySet().stream().map(m -> m.getValue().stream().s)
    }
}
