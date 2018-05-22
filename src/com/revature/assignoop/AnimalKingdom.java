package com.revature.assignoop;

public class AnimalKingdom {
    public static void main(String args[]){

        //Instantiated a new Puppy. The puppy is a dog. Dogs are Canines.
        Species Puppy = new Dog();
        Puppy.setSound("Woof");
        Puppy.setsName("Lupus");
        Puppy.setsSubName("Familaris"); //Since all Species have a Family, the Family name can be called.
        Puppy.setfName("Canis");

        System.out.println("The scientific name for your puppy is "+Puppy.getTrinomial()+"."); //Latin Trinomial using inherited nomenclature.

        //In case the puppy doesn't have a name.

        if(Puppy.getNickname()==null){
            try{
                throw new BlankInputException("Your puppy doesn't have a name.");
            }catch(BlankInputException e){
                e.printStackTrace();
            }finally{
                System.out.println("All puppies have names.");
            }
        }
    }
}

//The dog is an extension of species, but as a pet should have some pet-like attributes.

class Dog extends Species implements Pet{

//Implemented methods within the Pet class override.

    @Override
    public boolean canDoTricks() {
        return false;
    }

    @Override
    public boolean checkTemper() {
        return false;
    }
}
