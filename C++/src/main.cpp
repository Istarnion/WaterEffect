#include <iostream>

#include <SFML/Graphics.hpp>
#include <SFML/Window.hpp>
#include <SFML/System.hpp>

#include "assetmanager.h"
#include "game.h"

int main() {
    sf::RenderWindow window(
        sf::VideoMode(700, 600), "GOGUN",
        sf::Style::Default & ~sf::Style::Resize
    );
    window.setVerticalSyncEnabled(true);
  
    sf::Clock clock; 
    float delta;
    bool running = true;
    sf::Event event;
    
    AssetManager assetManager;

    Game game(assetManager, window);

    while(running) {
        while(window.pollEvent(event)) {
            if (event.type == sf::Event::Closed) {
                running = false;
            }
        }

        window.clear(sf::Color::Black);

        delta = clock.restart().asSeconds();
        game.update(delta);

        window.display();
    }

    return 0;
}

