uniform sampler2D texture;
uniform float time;

void main()
{
    float amplitude = 0.05;
    float freq = 2.0;
    float phase = 16.0;

    vec2 src = gl_TexCoord[0].xy;
    src.x += amplitude*cos(freq*time+src.y*phase);
    src.y += 0.005*sin(8.0*time+src.x*64.0);
    vec4 pixel = texture2D(texture, src);
    pixel.b = 1.0;

    gl_FragColor = gl_Color * pixel;
}

