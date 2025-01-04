import com.delogic.ticket.converter.UserConverter
import com.delogic.ticket.entity.User
import com.delogic.ticket.repository.UsersRepository
import com.delogic.ticket.service.UserService
import mock.UserMock
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import spock.lang.Specification

class UserServiceTest extends Specification {

    UsersRepository usersRepository
    UserConverter userConverter
    UserService service

    def setup() {
        usersRepository = Mock(UsersRepository)
        userConverter = Mock(UserConverter)
        service = new UserService(usersRepository, userConverter)
    }


    def "Should return users paginated"() {
        given:
        def pageable = Pageable.ofSize(10).withPage(1)
        def page = new PageImpl<User>(UserMock.USERS, pageable, 1000L)
        usersRepository.findAll(_ as Pageable) >> page

        when:
        def result = service.findAll(pageable)

        then:
        result.getTotalElements() == 1000
    }


}
