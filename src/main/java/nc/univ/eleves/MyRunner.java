package nc.univ.eleves;


import nc.univ.eleves.services.EleveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class MyRunner implements CommandLineRunner {

    @Autowired
    private EleveService eleveService;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        eleveService.generate();
    }
}