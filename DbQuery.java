public class DbQuery {
    /**
     * The math scores of each student have been stored in the STUDENT table. Write a query to print
     * the ID and the NAME of each of the three highest scoring students. Print the NAMEs in
     * descending order by SCORE, then ascending order by ID for matching SCOREs.
     */
    public void dbQuery(){
        String query = "select id,name from STUDENT order by score desc, id asc limit 3";
    }
}
