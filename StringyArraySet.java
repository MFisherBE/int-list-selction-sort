class StringyArraySet {
    private int count;
    private String [] members;

    public void trim()
    {
        // Declare new variable array to hold members string
        String[] newarray = members;

        // Declare new variable to hold "count"
        int mlength = count;

        // For loop to iterate from right-most elements (highest element)
        // and iterate downwards to nullify (delete) every element above
        // element #mlength (otherwise known as element #: count)
        for(int i = newarray.length; i > mlength; i--)
        {
            newarray[i] = null;
        }
    }
}
