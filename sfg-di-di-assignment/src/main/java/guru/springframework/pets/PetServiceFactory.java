package guru.springframework.pets;

public class PetServiceFactory {

    public PetService getPetService(String petType) {
        if (petType.equals("dog")) {
            return new DogPetService();
        } else {
            return new CatPetService();
        }
    }

}
