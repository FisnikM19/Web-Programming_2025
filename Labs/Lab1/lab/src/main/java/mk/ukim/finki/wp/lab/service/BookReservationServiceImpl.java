package mk.ukim.finki.wp.lab.service;

import mk.ukim.finki.wp.lab.model.BookReservation;
import mk.ukim.finki.wp.lab.repository.BookReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class BookReservationServiceImpl implements BookReservationService {

    private final BookReservationRepository bookReservationRepository;

    public BookReservationServiceImpl(BookReservationRepository bookReservationRepository) {
        this.bookReservationRepository = bookReservationRepository;
    }

    @Override
    public BookReservation placeReservation(String bookTitle, String readerName, String readerAddress, int numberOfCopies) {
        if (bookTitle == null || bookTitle.isEmpty()
                || readerName == null || readerName.isEmpty()
                || readerAddress == null || readerAddress.isEmpty()) {
            throw new IllegalArgumentException();
        }

        BookReservation bookReservation = new BookReservation(bookTitle, readerName, readerAddress, (long) numberOfCopies);

        return bookReservationRepository.save(bookReservation);
    }
}
