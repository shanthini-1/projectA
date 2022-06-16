       this is similar to this.director = filmdirector   but using this. prefix is not compulsory
	   as there are no local variable by name title, or director 
	       so here they will implicitly referred to global variable
	   note : If the title and director are not globally declare then it will be undeclred variable
	   If the parameter name are equal to global variable
	   then there is an ambiguity between the local variable (parameters) and global variable 
	   hence this.prefix is used for referring the global variable.
	   title = title will be referring the local variable and both side of the = the operator