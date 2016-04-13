#include "game.h"

#include <cstring>

Game::Game(AssetManager& am, sf::RenderWindow& win) :
    assetManager(am), window(win) {

    bg = assetManager.getSprite("bg");
    pillar = assetManager.getSprite("pillar");
    pillar.setPosition(400, 400);

    waterShader.loadFromFile("resources/water.frag", sf::Shader::Fragment);
    waterShader.setParameter("texture", sf::Shader::CurrentTexture);
}

Game::~Game() {
}

void Game::update(float delta) {
    timePassed += delta;
    waterShader.setParameter("time", timePassed);
    window.draw(bg, &waterShader);
    window.draw(pillar);
    
}

