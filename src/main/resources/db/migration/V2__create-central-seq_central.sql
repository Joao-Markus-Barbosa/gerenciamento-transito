

CREATE TABLE IF NOT EXISTS public.central (
    id_central BIGSERIAL PRIMARY KEY,
    user_name_central VARCHAR(100) NOT NULL UNIQUE,
    senha_acesso VARCHAR(100) NOT NULL,
    role VARCHAR(100) NOT NULL
);
