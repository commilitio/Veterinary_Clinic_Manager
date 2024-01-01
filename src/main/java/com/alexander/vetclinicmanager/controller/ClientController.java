/*
    Oto przykładowa implementacja klasy `ClientController` opierająca się na kodzie `ClientService`:

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/{clientId}")
    public Client getClientById(@PathVariable Long clientId) {
        return clientService.findById(clientId);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.findAllClients();
    }

    @PostMapping
    public Client createClient(@RequestBody Client client) {
        return clientService.createClient(client);
    }

    @PutMapping("/{clientId}")
    public void updateClient(@PathVariable Long clientId, @RequestBody Client client) {
        client.setId(clientId);
        clientService.updateClient(client);
    }

    @DeleteMapping("/{clientId}")
    public void deleteClient(@PathVariable Long clientId) {
        clientService.deleteClient(clientId);
    }

    @GetMapping("/search")
    public List<Client> searchClientsByLastName(@RequestParam String prefix) {
        return clientService.findClientsByLastNameStartingWith(prefix);
    }
}
```

W tym przykładzie:

1. `@RestController` oznacza, że klasa będzie obsługiwała zapytania HTTP i automatycznie serializować/ deserializować dane w formacie JSON.
2. `@RequestMapping("/clients")` ustawia główny adres URL dla wszystkich endpointów w kontrolerze.
3. Endpointy obsługują zapytania HTTP GET, POST, PUT i DELETE do operacji na klientach.
4. Adnotacja `@PathVariable` wskazuje, że wartość w nawiasach klamrowych `{clientId}` zostanie przekazana jako argument metody.
5. Adnotacja `@RequestBody` wskazuje, że dane będące ciałem zapytania będą automatycznie deserializowane do obiektu `Client`.
6. W przypadku operacji `updateClient`, należy przekazać identyfikator klienta jako część ścieżki (`/clients/{clientId}`) i obiekt klienta jako ciało zapytania.

Upewnij się, że masz odpowiednio skonfigurowaną obsługę adnotacji `@RestController` i `@RequestMapping` w konfiguracji Spring.
 */

package com.alexander.vetclinicmanager.controller;

import com.alexander.vetclinicmanager.model.Client;
import com.alexander.vetclinicmanager.service.ClientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService clientService;


    public ClientController(ClientService clientService) {          // wymagany konstruktor
        this.clientService = clientService;
    }


    @GetMapping("/{id}")
    public Client findById(@PathVariable Long id){
        return clientService.findById(id);
    }


    @GetMapping("/clients")
    public List <Client> findAllClients(){
        return clientService.findAllClients();
    }


    @PostMapping("/newClient")
    public Client createClient(@RequestBody Client client){
        return clientService.createClient(client);
    }


    public void updateClient(Client client){

    }
}






















