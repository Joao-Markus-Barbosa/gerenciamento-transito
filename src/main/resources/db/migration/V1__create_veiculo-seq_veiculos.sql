
CREATE TABLE IF NOT EXISTS public.veiculo (
    id_veiculo BIGSERIAL PRIMARY KEY,
    modelo_veiculo VARCHAR(100) NOT NULL
);

CREATE TABLE IF NOT EXISTS public.camera (
    id_camera BIGSERIAL PRIMARY KEY,
    qt_passagem_veiculo INTEGER NOT NULL,
    data_passagem_veiculo DATE NOT NULL,
    nm_avenida VARCHAR(100) NOT NULL
);
