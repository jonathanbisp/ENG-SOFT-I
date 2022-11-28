package users.behaviors;

import users.User;

public class ReserveMaxThree implements ReserveBehavior {

    @Override
    public boolean isAbleToReserve(User user) {
        Integer limit_books = 3;

        if (user.amountReservedBook() < limit_books) {
            return true;
        } else {
            System.out.println(
                    "FALHA AO REALIZAR A RESERVA AO USUARIO: "
                            + user.getName()
                            + "POIS JA ATINGIU O LIMITE DE RESERVAS");
            return false;
        }
    }

}
