/** A collection of EmployeeSkill collections mapped to Employee names
 *
 */

import java.util.TreeMap;
import java.util.ArrayList;

public class EmployeeSkillMap {

    TreeMap<String, ArrayList<EmployeeSkill>> map;

    public EmployeeSkillMap(){
        map = new TreeMap();
    }

    /** Checks for the key and instance of the ArrayList
     *
     * @param key The key to search for
     */
    private boolean ensureInstance(String key){
        boolean found = false;
    	if (map.get(key) != null && map.containsKey(key))
            found = true;
        else if (!map.containsKey(key)){
            System.out.println("ERROR: No entry for Key: " + key +
                " found.");
        }
    	return found;
    }

    /** Returns the TreeMap
     *
     * @return The TreeMap
     */
    public TreeMap<String, ArrayList<EmployeeSkill>> getMap(){
        return this.map;
    }

    /** Adds an employee without adding any skills.
     * Instantiates the ArrayList
     *
     * @param name Name of the employee to add to the map
     */
    public void addEmployee(String name){
        map.put(name, new ArrayList());
    }

    /**Adds a skill to the ArrayList mapped to the employee
     *
     * @param name the key value to add the skill to
     * @param skill the skill to be added
     */
    public void addSkill(String name, EmployeeSkill skill){
        if(ensureInstance(name))
        	map.get(name).add(skill);
    }
    
    public void addSkill(String name, String skill){
    	addSkill(name, new EmployeeSkill(skill));
    }

    public boolean checkSkill(String name, EmployeeSkill skill){
        boolean result = false;
        ArrayList s = map.get(name);
        for (int i = 0; i < s.size(); i++){
            if (s.get(i).equals(skill)) {
                result = true;
                break;
            }
        }
        return result;
    }
}
