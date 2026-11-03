public class SkillRule extends EligibilityRule {
    @Override
    public String getRuleName() {
        return "Skills";
    }

    @Override
    public boolean check(Candidate candiadate, Job job) {
        String[] requiredSkills = job.getRequiredSkills();
        for (int i = 0; i < requiredSkills.length; i++) {
            if (!candiadate.hasSkill(requiredSkills[i])) {
                return false;
            }
        }
        return true;
    }
}
