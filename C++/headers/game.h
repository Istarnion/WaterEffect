#pragma once
#ifndef GOGUN_GAME_H
#define GOGUN_GAME_H

#include <iostream>
#include <vector>
#include <stdlib.h>

#include <SFML/Graphics.hpp>

#include "assetmanager.h"

class Game {
    private:

        AssetManager& assetManager;

        sf::Sprite pillar;

        sf::Sprite bg;
        sf::Shader waterShader;
        float timePassed;

        sf::RenderWindow& window;

    public:
        Game(AssetManager& am, sf::RenderWindow& win);
        ~Game();

        void update(float delta);

};

#endif // GOGUN_GAME_H
