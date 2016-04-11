/**
 * Created by Mark on 4/9/16.
 */
public class EmployeeSkill {

    /*public enum Skill {
        manager, prep, cordinator, dining, dishes, cashier, salad,
        sandwhich, consolidator, expiditer
    }*/

    enum Skills{
        MANAGER("manager"),
        PREP("prep"),
        COORDINATOR("coordinator"),
        DINING("dining"),
        DISHES("dishes"),
        CASHIER("cashier"),
        SALAD("salad"),
        SANDWHICH("sandwich"),
        CONSOLIDATOR("consolidator"),
        EXPEDITER("expediter");

        final String SKILL_NAME;

        private Skills(final String SKILL_NAME){
            this.SKILL_NAME = SKILL_NAME;
        }

    }

    Skills skill;

    public EmployeeSkill(Skills skill){
        this.skill = skill;
    }

    //@Override
    public boolean equals(Skills aSkill){
        //return skill.SKILL_NAME == aSkill.SKILL_NAME;
        return skill.equals(aSkill);
    }

    public static void main(String[] args){

        EmployeeSkill skill1 = new EmployeeSkill(Skills.PREP);
        EmployeeSkill skill2 = new EmployeeSkill(Skills.PREP);

        System.out.println(skill1.equals(1));
        System.out.println(skill1.equals((Skills.PREP)));
        System.out.println(skill1.equals(skill1));
        System.out.println(skill1 == new EmployeeSkill(Skills.PREP));
        System.out.println(skill1.equals(skill2));
    }
}
